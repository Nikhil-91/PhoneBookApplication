package com.chase.PhoneBookApplication.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.PhoneBookApplication.DTO.Contact;
import com.chase.PhoneBookApplication.Repository.ContactDtlsEntity;
import com.chase.PhoneBookApplication.Repository.ContactDtlsRepository;
@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDtlsRepository contactDtlRepo;

	@Override
	public boolean saveContact(Contact contact) {
		ContactDtlsEntity entity=new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity);
		ContactDtlsEntity savedEntity=contactDtlRepo.save(entity);
		return savedEntity.getCid() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactDtlsEntity> entities=contactDtlRepo.findAll();
		List<Contact> contacts=new ArrayList<Contact>();
		entities.forEach(entitie -> {
			Contact c=new Contact();
			BeanUtils.copyProperties(entitie, c);
			contacts.add(c);
		});
		return contacts;
	}

	@Override
	public Contact getContactById(Integer id) {
		Contact contact=new Contact();
		Optional<ContactDtlsEntity> entity=contactDtlRepo.findById(id);
		BeanUtils.copyProperties(entity.get(), contact);
		return contact;
	}

	@Override
	public boolean deleteContact(Integer id) {
		contactDtlRepo.deleteById(id);
		return true;
	}

}
