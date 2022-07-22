package com.ITOTracker.ITOITSupportTracker.controller;

import com.ITOTracker.ITOITSupportTracker.entity.CreateTicket;
import com.ITOTracker.ITOITSupportTracker.entity.ViewTicket;
import com.ITOTracker.ITOITSupportTracker.entity.ViewTicketList;
import com.ITOTracker.ITOITSupportTracker.entity.Comment;
import com.ITOTracker.ITOITSupportTracker.exception.ResourceNotFoundException;
import com.ITOTracker.ITOITSupportTracker.repository.*;
import com.ITOTracker.ITOITSupportTracker.service.UserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserModuleController {
    @Autowired
    private UserModuleService userModuleService;
    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private TicketsCreateRepository ticketsCreateRepository;
    @Autowired
    private ViewALLRepository viewALLRepository;
    @Autowired
     private CommentRepository commentRepository;
/*
•	Create Ticket
 */
 String url="http://localhost:8183/api/usermodule";
    @PostMapping("/UserModule")
    public String createTicket (@RequestBody CreateTicket createTicket,@RequestParam Integer user_id) {
        if (createTicket==null) {
            return "failed to create";
        }
        CreateTicket userResponseModel1=new CreateTicket();
        userResponseModel1.setReported_id(user_id);
        userResponseModel1.setTicket_id(createTicket.getTicket_id());
        userResponseModel1.setPriority_id(createTicket.getPriority_id());
        userResponseModel1.setCategory_id(createTicket.getCategory_id());
        userResponseModel1.setUser_id(user_id);
        userResponseModel1.setSub_category_id(createTicket.getSub_category_id());
        userResponseModel1.setSubjects(createTicket.getSubjects());
        userResponseModel1.setStatus_id(201);
       userResponseModel1.setDescription(createTicket.getDescription());
        System.out.println(LocalDateTime.now());
        //userResponseModel1.setAssignee_Id(createTicket.getAssignee_Id());
        userResponseModel1.setCreate_datetime(LocalDateTime.now());
        this.ticketsCreateRepository.save(userResponseModel1);
        return "Ticket created Successfully " +  userResponseModel1.getTicket_id() + " " + url;
    }

// View All the table details.

    @GetMapping("/UserModule")
    public List<ViewTicket> ViewById() {
        userModuleService.ViewById();
         return this.viewALLRepository.findAll();
    }
/* 	View Ticket List:
•	Ticket_id
•	Category
•	Subcategory
•	Subject
•	Priority
•	Status
•	Assignee
•	Link for ticket
 */
    @Autowired
    private ViewTicketListRepository viewTicketListRepository;
 @GetMapping("/viewTicketList")
   public List<ViewTicketList> ViewByTicketList() {
      userModuleService.ViewByTicketList();
    return  this.viewTicketListRepository.findAll();
   }
/*
•	View the Ticket by user id
    Ticket_id
•	Category
•	Subcategory
•	Subject
•	Priority
•	Status
•	Assignee
•	Link for ticket
 */

@GetMapping("UserModule/viewTicketByUser_id")
public List<ViewTicketList> ViewByUserId( @RequestParam Integer user_id) {

    List<ViewTicketList> viewTicketList = userModuleService.ViewByUserId(user_id);
    if(viewTicketList.isEmpty())
    {
        return (List<ViewTicketList>) viewTicketListRepository.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("user id not found with id :" + user_id, "Missing Data Exception"));
    }
return viewTicketList;
}


/*
•	Comment on Ticket.
send user id and ticket id request param
 */
    @PostMapping("UserModule/Usercomment")
    public String 	CommentOnTicket(@RequestBody String message,@RequestParam Integer ticket_id,@RequestParam Integer user_id) {
        CreateTicket createTicket1 = new CreateTicket();
        List<CreateTicket> createTicketList;
        createTicketList = ticketsCreateRepository.findAll();
        System.out.println(createTicketList);
        for (CreateTicket createTicket : createTicketList) {
            while (user_id == createTicket.getUser_id() && ticket_id == createTicket.getTicket_id()) {
                Comment comment = new Comment();
                comment.setTicket_id(ticket_id);
                comment.setUser_id(user_id);
                comment.setMessage(message);
                this.commentRepository.save(comment);
                return "Successfully Added Comment on <" + ticket_id + ">";
            }
        }
        return new ResourceNotFoundException("ticket_id and user_id not correct", "Missing Data Exception") + "";
    }
}
