package com.ITOTracker.ITOITSupportTracker.service;

import com.ITOTracker.ITOITSupportTracker.DAO.CreateTicket;
import com.ITOTracker.ITOITSupportTracker.DAO.ITViewTicket;
import com.ITOTracker.ITOITSupportTracker.DAO.ViewTicket;
import com.ITOTracker.ITOITSupportTracker.DAO.ViewTicketList;
import com.ITOTracker.ITOITSupportTracker.entity.*;
import com.ITOTracker.ITOITSupportTracker.exception.ResourceNotFoundException;
import com.ITOTracker.ITOITSupportTracker.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ITTeamModuleService {
    @Autowired
    private TicketsCreateRepository ticketsCreateRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private PriorityRepository priorityRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private CommentRepository commentRepository;
    public Category findByCategoryId(Integer category_id) {
        return categoryRepository.getReferenceById(category_id);
    }

    public Sub_Category findBySubCayegoryId(Integer sub_category_id) {
        return subCategoryRepository.getReferenceById(sub_category_id);
    }
    public User findByUserId(Integer user_id) {
        return userRepository.getReferenceById(user_id);
    }
    public Priority findByPriorityId(Integer priority_id) {
        return priorityRepository.getReferenceById(priority_id);
    }

    public Status findByStatusId(Integer status_id) {
        return statusRepository.getReferenceById(status_id);
    }
    public Tickets findByTicketId(Integer ticket_id)
    {
        return ticketsRepository.getReferenceById(ticket_id);
    }
    public Comment findByCommentId(Integer comment_id)
    {
    return commentRepository.getReferenceById(comment_id);
    }

    @Autowired
    private ViewALLRepository viewALLRepository;
    public List<ViewTicket> ViewById() {
        List<CreateTicket> createTicketList;
        List<ViewTicket> viewTicketList = new ArrayList<>();
        createTicketList = ticketsCreateRepository.findAll();
        System.out.println(createTicketList);
        for (CreateTicket createTicket : createTicketList) {
            ViewTicket viewTicket = new ViewTicket();
            System.out.println(createTicket.getTicket_id());
            viewTicket.setTicket_id(createTicket.getTicket_id());
            System.out.println(createTicket.getAssignee_Id());
            viewTicket.setAssignee_Id(createTicket.getAssignee_Id());
            System.out.println(createTicket.getSubjects());
            viewTicket.setSubjects(createTicket.getSubjects());
            viewTicket.setDescription(createTicket.getDescription());
            viewTicket.setUrl_link(createTicket.getUrl_link());
            //viewTicket.setUser_id(createTicket.getUser_id());
            viewTicket.setCategory(findByCategoryId(createTicket.getCategory_id()));
            viewTicket.setSub_category(findBySubCayegoryId(createTicket.getSub_category_id()));
            viewTicket.setPriority(findByPriorityId(createTicket.getPriority_id()));
            viewTicket.setStatus(findByStatusId(createTicket.getStatus_id()));
            viewALLRepository.save(viewTicket);
            viewTicketList.add(viewTicket);
        }
        return viewTicketList;
    }
    @Autowired
    private ViewTicketListRepository viewTicketListRepository;
    public  List<ViewTicketList> ViewByTicketList() {
        List<CreateTicket> createTicketList;
        List<ViewTicketList> viewTicketList = new ArrayList<>();
        createTicketList = ticketsCreateRepository.findAll();
        System.out.println(createTicketList);
        for (CreateTicket createTicket : createTicketList) {
            ViewTicketList viewTicket = new ViewTicketList();
            System.out.println(createTicket.getTicket_id());
            viewTicket.setTicket_id(createTicket.getTicket_id());
            System.out.println(createTicket.getAssignee_Id());
            viewTicket.setAssignee_Id(createTicket.getAssignee_Id());
            System.out.println(createTicket.getSubjects());
            viewTicket.setSubjects(createTicket.getSubjects());
            viewTicket.setUrl_link(createTicket.getUrl_link());
            viewTicket.setCategory_desc(findByCategoryId(createTicket.getCategory_id()).getCategory_desc());
            viewTicket.setSub_category_desc(findBySubCayegoryId(createTicket.getSub_category_id()).getSub_category_desc());
            viewTicket.setStatus_name(findByStatusId(createTicket.getStatus_id()).getStatus_name());
            viewTicket.setPriority_name(findByPriorityId(createTicket.getPriority_id()).getPriority_name());
           viewTicket.setUser_id(createTicket.getUser_id());
            viewTicketListRepository.save(viewTicket);
            viewTicketList.add(viewTicket);
        }
        return viewTicketList;
    }

    public List<ViewTicketList> ViewByUserId( Integer user_id) {
        List<CreateTicket> createTicketList;
        List<ViewTicketList> viewTicketList = new ArrayList<>();
        createTicketList = ticketsCreateRepository.findAll();
        for (CreateTicket createTicket : createTicketList) {
            ViewTicketList viewTicket = new ViewTicketList();
            if (user_id == createTicket.getUser_id()) {
                System.out.println(createTicket.getTicket_id());
                viewTicket.setTicket_id(createTicket.getTicket_id());
                System.out.println(createTicket.getAssignee_Id());
                viewTicket.setAssignee_Id(createTicket.getAssignee_Id());
                System.out.println(createTicket.getSubjects());
                viewTicket.setSubjects(createTicket.getSubjects());
                viewTicket.setUrl_link(createTicket.getUrl_link());
                viewTicket.setCategory_desc(findByCategoryId(createTicket.getCategory_id()).getCategory_desc());
                viewTicket.setSub_category_desc(findBySubCayegoryId(createTicket.getSub_category_id()).getSub_category_desc());
                viewTicket.setStatus_name(findByStatusId(createTicket.getStatus_id()).getStatus_name());
                viewTicket.setPriority_name(findByPriorityId(createTicket.getPriority_id()).getPriority_name());
               viewTicket.setUser_id(createTicket.getUser_id());
                viewTicketList.add(viewTicket);
            }

        }
        return viewTicketList;
    }
public List<ITViewTicket> ViewByTicket_id(Integer ticket_id)
{
    List<CreateTicket> createTicketList;
    List<ITViewTicket> viewTicketList = new ArrayList<>();
    createTicketList = ticketsCreateRepository.findAll();
    for (CreateTicket createTicket : createTicketList) {
       if(ticket_id == createTicket.getTicket_id()) {
           ITViewTicket itViewTicket = new ITViewTicket();
            itViewTicket.setTicket_id(createTicket.getTicket_id());
            itViewTicket.setCategory_id(createTicket.getCategory_id());
            itViewTicket.setSub_category_id(createTicket.getSub_category_id());
            itViewTicket.setDescription(createTicket.getDescription());
            itViewTicket.setSubjects(createTicket.getSubjects());
            itViewTicket.setAssignee_Id(createTicket.getAssignee_Id());
            itViewTicket.setPriority_id(createTicket.getPriority_id());
            itViewTicket.setStatus_id(createTicket.getStatus_id());
            itViewTicket.setCreate_datetime(createTicket.getCreate_datetime());
            itViewTicket.setReported_id(createTicket.getReported_id());
            itViewTicket.setLast_modified_datetime(createTicket.getLast_modified_datetime());
            itViewTicket.setUser_id(createTicket.getUser_id());
              List<User> Userlist= userRepository.findAll();
               for (User user : Userlist) {
                   System.out.println(user.getUser_id());
                   Integer user_id= Integer.valueOf(user.getUser_id());
                   if (createTicket.getUser_id()==user_id) {
                       itViewTicket.setUser_name(findByUserId(createTicket.getUser_id()).getUser_name());
                       break;
                   }
               }
           List<Comment> comments=commentRepository.findAll();
           for (Comment comment : comments) {
               System.out.println(createTicket.getTicket_id());
               System.out.println(comment.getTicket_id());
               if (comment.getTicket_id()==createTicket.getTicket_id()) {
                   itViewTicket.setMessage(findByCommentId(comment.getComment_id()).getMessage());
                   break;
               }
           }
           viewTicketList.add(itViewTicket);
        }
    }
        return viewTicketList;
    }

    public CreateTicket SetAssigneeById(Integer ticket_id,Integer user_id,Integer admin_id) {
        List<CreateTicket> createTicketList;
        createTicketList = ticketsCreateRepository.findAll();
        CreateTicket createTicket=new CreateTicket();
        for (CreateTicket createTicket1 : createTicketList) {
            if (ticket_id == createTicket1.getTicket_id() && user_id == createTicket1.getUser_id()) {
                createTicket.setReported_id(user_id);
                createTicket.setTicket_id(createTicket1.getTicket_id());
                createTicket.setPriority_id(createTicket1.getPriority_id());
                createTicket.setCategory_id(createTicket1.getCategory_id());
                createTicket.setAssignee_Id(admin_id);
                createTicket.setUser_id(user_id);
                createTicket.setSub_category_id(createTicket1.getSub_category_id());
                createTicket.setSubjects(createTicket1.getSubjects());
                createTicket.setStatus_id(createTicket1.getStatus_id());
                createTicket.setDescription(createTicket1.getDescription());
                createTicket.setCreate_datetime(LocalDateTime.now());
                createTicket.setLast_modified_datetime(createTicket1.getLast_modified_datetime());
              this.ticketsCreateRepository.save(createTicket);
            }
        }
        System.out.println(createTicket);
        return createTicket;
    }

    public CreateTicket SetStatus(Integer ticket_id,Integer user_id,Integer status_id) {
        List<CreateTicket> createTicketList;
        createTicketList = ticketsCreateRepository.findAll();
        CreateTicket createTicket=new CreateTicket();
        for (CreateTicket createTicket1 : createTicketList) {
            if (ticket_id == createTicket1.getTicket_id() && user_id == createTicket1.getUser_id()) {
                createTicket.setReported_id(user_id);
                createTicket.setTicket_id(createTicket1.getTicket_id());
                createTicket.setPriority_id(createTicket1.getPriority_id());
                createTicket.setCategory_id(createTicket1.getCategory_id());
                createTicket.setAssignee_Id(createTicket1.getAssignee_Id());
                createTicket.setUser_id(user_id);
                createTicket.setSub_category_id(createTicket1.getSub_category_id());
                createTicket.setSubjects(createTicket1.getSubjects());
                createTicket.setStatus_id(202);
                createTicket.setDescription(createTicket1.getDescription());
                createTicket.setCreate_datetime(createTicket1.getCreate_datetime());
                createTicket.setLast_modified_datetime(LocalDateTime.now());
                this.ticketsCreateRepository.save(createTicket);
            }
        }
        System.out.println(createTicket);
        return createTicket;
    }

}
