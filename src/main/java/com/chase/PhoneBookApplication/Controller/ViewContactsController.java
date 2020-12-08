package com.chase.PhoneBookApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chase.PhoneBookApplication.DTO.Contact;
import com.chase.PhoneBookApplication.Service.ContactService;
@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService contactservice;

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer cid,Model model) {
		Contact contact=contactservice.getContactById(cid);
		model.addAttribute("Contact",contact);
		return "index";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(Integer cid,RedirectAttributes reddr) {
		contactservice.deleteContact(cid);
		reddr.addFlashAttribute("msg", "Contact Deleted Successfully");
		return "redirect:ViewContacts";
	}
}
