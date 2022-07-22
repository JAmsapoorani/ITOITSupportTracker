package com.ITOTracker.ITOITSupportTracker.controller;

import com.ITOTracker.ITOITSupportTracker.entity.CreateTicket;
import com.ITOTracker.ITOITSupportTracker.entity.ITViewTicket;
import com.ITOTracker.ITOITSupportTracker.entity.ViewTicket;
import com.ITOTracker.ITOITSupportTracker.entity.ViewTicketList;
import com.ITOTracker.ITOITSupportTracker.entity.Admin_team;
import com.ITOTracker.ITOITSupportTracker.entity.Comment;
import com.ITOTracker.ITOITSupportTracker.exception.ResourceNotFoundException;
import com.ITOTracker.ITOITSupportTracker.repository.*;
import com.ITOTracker.ITOITSupportTracker.service.ITTeamModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ITTeamModuleController {
    @Autowired
    private ITTeamModuleService itTeamService;
    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private TicketsCreateRepository ticketsCreateRepository;
    @Autowired
    private ViewALLRepository viewALLRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ITViewTicketRepository itViewTicketRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private StatusRepository statusRepository;

// View All the table details.

    @GetMapping("/ITTeamModule/ViewALLTicketList")
    public List<ViewTicket> ViewById() {
        List<ViewTicket> viewTicketList= itTeamService.ViewById();
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
    @GetMapping("/ITTeamModule/ViewTicketList")
    public List<ViewTicketList> ViewByTicketList() {
        itTeamService.ViewByTicketList();
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

    @GetMapping("/ITTeamModule/ViewTicketByUser_id")
    public List<ViewTicketList> ViewByUserId( @RequestParam Integer user_id) {

        List<ViewTicketList> viewTicketList = itTeamService.ViewByUserId(user_id);
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
    @PostMapping("/ITTeamModule/ITTeamComment")
    public String 	CommentOnTicket(@RequestBody String message, @RequestParam Integer ticket_id, @RequestParam Integer user_id) {
        CreateTicket createTicket1 = new CreateTicket();
        List<CreateTicket> createTicketList;
        createTicketList = ticketsCreateRepository.findAll();
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
    /* view Ticket
    	IT Team Member can fetch the ticket using Ticket ID
	Return Complete Information For that ticket and list all the communication in that ticket.
	Communication message List contain
	Sender name
	Message

     */

    @GetMapping("/ITTeamModule/ViewTicketLists/{ticket_id}")
    public List<ITViewTicket>  ViewTicketList(@PathVariable Integer ticket_id)
    {
        List<ITViewTicket> viewTicketList = itTeamService.ViewByTicket_id(ticket_id);
        CreateTicket createTicket1 = new CreateTicket();
        List<CreateTicket> createTicketList;
        createTicketList = ticketsCreateRepository.findAll();
        System.out.println(ticket_id);
        boolean flag=true;
        for (CreateTicket createTicket : createTicketList) {
            if (ticket_id == createTicket.getTicket_id()) {
                flag=true;
                break;
            }
            else
            {
                flag=false;
            }
        }
        if(flag==false)
        {
             return (List<ITViewTicket>) itViewTicketRepository.findById(ticket_id).orElseThrow(() -> new ResourceNotFoundException(" Invalid Ticket Id" + ticket_id, "Missing Data Exception"));
        }
            return viewTicketList;
    }
    /*
    	Set Assignee
	IT Team Member can Set the assignee.
	Send the ticket id and admin
	User id in request param for set the assignee
	Set the current date time value for last_modified_datetime field.

     */
    @PutMapping("/ITTeamModule/SetAssignee")
    public CreateTicket  setAssignee(@RequestParam Integer ticket_id,@RequestParam Integer admin_id,@RequestParam Integer user_id) {
       List<CreateTicket> createTicketList;
        List<Admin_team> admin_teams;
        admin_teams=adminRepository.findAll();
        CreateTicket createTicket=new CreateTicket();
        for(Admin_team admin:admin_teams)
        {
            if(admin.getAdmin_id()==admin_id) {
                createTicketList = ticketsCreateRepository.findAll();
                for (CreateTicket createTicket1 : createTicketList) {
                    if (ticket_id == createTicket1.getTicket_id() && user_id == createTicket1.getReported_id()) {
                       return itTeamService.SetAssigneeById(ticket_id, user_id, admin_id);
                    }
                }
            }
        }
        return ticketsCreateRepository.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("Incorrect Ticket Id and user Id: " +user_id,"Missing Data Exception"));
    }
/*
    Change The Status
	IT Team Member can change the Status
	Send the Ticket Id, Status Id and User Id as request parameter.
	If any of the id is invalid return appropriate Error message.
	After Updating the status Update the last_modified_datetime with current date time
 */
@PutMapping("/ITTeamModule/ChangeStatus")
public String ChangeStatus(@RequestParam Integer ticket_id,@RequestParam Integer status_id,@RequestParam Integer user_id) {
    List<CreateTicket> createTicketList;
    createTicketList = ticketsCreateRepository.findAll();
    CreateTicket createTicket = new CreateTicket();
    String oldstatus="";
    for (CreateTicket createTicket1 : createTicketList) {
        if (ticket_id == createTicket1.getTicket_id() && user_id == createTicket1.getReported_id()) {
            oldstatus=statusRepository.getReferenceById(createTicket1.getStatus_id()).getStatus_name();
        }
        }
    String returnStatus = "";
    boolean flag = true;
    for (CreateTicket createTicket1 : createTicketList) {
        if (ticket_id == createTicket1.getTicket_id() && user_id == createTicket1.getReported_id()) {
            flag = false;

            itTeamService.SetStatus(ticket_id, user_id, status_id);
            returnStatus = "Status Change from <" + oldstatus + "> to <" + statusRepository.getReferenceById(status_id).getStatus_name() + ">";
        }
    }
    if (flag == true) {
        return ticketsCreateRepository.findById(user_id).orElseThrow(() -> new ResourceNotFoundException("Incorrect Ticket Id and user Id: " + user_id, "Missing Data Exception")) + "";
    }
    return returnStatus;
}
}
