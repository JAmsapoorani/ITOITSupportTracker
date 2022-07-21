package com.ITOTracker.ITOITSupportTracker.service;

import com.ITOTracker.ITOITSupportTracker.DAO.CreateTicket;
import com.ITOTracker.ITOITSupportTracker.DAO.ViewTicket;
import com.ITOTracker.ITOITSupportTracker.DAO.ViewTicketList;
import com.ITOTracker.ITOITSupportTracker.entity.*;
import com.ITOTracker.ITOITSupportTracker.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserModuleService {
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
    @Autowired
    private ViewALLRepository viewALLRepository;
   public  List<ViewTicket> ViewById() {
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
           System.out.println(createTicket.getDescription());
               viewTicket.setDescription(createTicket.getDescription());
           System.out.println(createTicket.getUrl_link());
               viewTicket.setUrl_link(createTicket.getUrl_link());
           System.out.println(createTicket.getCategory_id());
               viewTicket.setCategory(findByCategoryId(createTicket.getCategory_id()));
               viewTicket.setSub_category(findBySubCayegoryId(createTicket.getSub_category_id()));
               viewTicket.setPriority(findByPriorityId(createTicket.getPriority_id()));
           System.out.println(createTicket.getStatus_id());
               viewTicket.setStatus(findByStatusId(createTicket.getStatus_id()));
               viewALLRepository.save(viewTicket);
               viewTicketList.add(viewTicket);
       }
       System.out.println(viewTicketList);
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

}
