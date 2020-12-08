package com.chase.PhoneBookApplication.Service;

import java.util.List;

import com.chase.PhoneBookApplication.DTO.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact contact);
	public List<Contact> getAllContacts();
	public Contact getContactById(Integer id);
	public boolean deleteContact(Integer id);

}
