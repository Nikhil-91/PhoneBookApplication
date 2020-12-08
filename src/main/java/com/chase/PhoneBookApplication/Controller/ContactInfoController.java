package com.chase.PhoneBookApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chase.PhoneBookApplication.DTO.Contact;
import com.chase.PhoneBookApplication.Service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactService contactservice;
	
	@GetMapping(value= {"/","loadForm"})
	public String index(Model model) {
		Contact c=new Contact();
		model.addAttribute("Contact",c);
		return "index";
		}
	@PostMapping("/submit")
	public String handleSubmitBtn(@ModelAttribute("Contact") Contact c , RedirectAttributes redd) {
		boolean res=contactservice.saveContact(c);
		if(res) {
			if(c.getCid() != null) {
				redd.addFlashAttribute("success", "Contact Updated Successfully");
			}else {
				redd.addFlashAttribute("success", "Contact Added Successfully");
			}
			
		}else {
			redd.addFlashAttribute("error", "Contact failed to insert");
		}
		return "redirect:loadForm";
	}
	
	@GetMapping("/ViewContacts")
	public String handleViewCntrlHyperLink(Model model) {
		List<Contact> contacts=contactservice.getAllContacts();
		model.addAttribute("Contacts",contacts);
		return "ViewContacts";
	}

}
