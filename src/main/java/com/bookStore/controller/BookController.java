package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        if (session.getAttribute("admin") == null) {
            return "redirect:/admin/login";
        }
        // Your existing code for the dashboard
        return "home";
    }
	@GetMapping("/")
	public String admin() {
		return "admin-login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	//extra codes
	@GetMapping("/login")
    public String adminLoginForm() {
        return "admin-login";
    }

    @PostMapping("/login")
    public String adminLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (username.equals("admin") && password.equals("admin")) {
            session.setAttribute("admin", "true");
            return "redirect:/dashboard";
        } else {
            return "admin-login";
        }
    }
    

    //extra codes
	
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	@GetMapping("/available_book")
	public ModelAndView getAllBook(){
		List<Book>list=service.getAllBook();
		return new ModelAndView("booklist","book",list);
		
	}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_book";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id){
		service.deleteById(id);
		return "redirect:/available_book";
		
	}
}

