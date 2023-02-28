package com.starters.dodu.controller;

import com.starters.dodu.domain.*;
import com.starters.dodu.domain.enums.VerificationStatus;
//import com.starters.dodu.dto.CategoryDTO;
//import com.starters.dodu.dto.MentorDTO;
import com.starters.dodu.dto.*;
import com.starters.dodu.service.*;
import com.starters.dodu.utils.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final MenteeService menteeService;
    private final ApplyService applyService;
    private final MentorService mentorService;
    private final VerificationService verificationService;
    private final MatchingService matchingService;
    private final CategoryService categoryService;
    private final ChatService chatService;
    private final AdminService adminService;

    @GetMapping("/admin")
    public  String admin(HttpSession session){
        // test (다시 return만 남기고 되돌리기!)
        System.out.println("[getAttrName] : " + session.getAttributeNames());
        System.out.println("[servletContext] : " +session.getServletContext());
        System.out.println("[admin] : " +session.getAttribute("admin"));
        //System.out.println("[admin] : " +session.getAttribute("admin").toString());
        System.out.println("[adminDetails] : " +session.getAttribute("adminDetails"));
        //System.out.println("[adminDetails] : " +session.getAttribute("adminDetails").toString());
        return "admin-login";
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam String adminName, @RequestParam String password, HttpSession session) {
        boolean isAuthenticated = adminService.authenticate(adminName, password);

        if (isAuthenticated) {
            Optional<Admin> admin = adminService.findAdminByAdminNameAndPassword(adminName, password);
            session.setAttribute("admin", admin);
            // filter
            session.setAttribute(SessionConst.LOGIN_ADMIN, admin);
            System.out.println("로그인 성공");
            System.out.println(admin);
            System.out.println(admin.get().getAdminName());
            System.out.println(admin.get().getNickname());
            return "redirect:/admin/home";
        } else {
            System.out.println("로그인 실패");

            return "redirect:/admin"; // 수정 (여기서 잘못된 로그인 처리가 됨!) - CustomLogInFailureHandler 동작X
        }
    }
    @GetMapping("/getAdmin")
    public String getAdminInfo(Model model, HttpSession session){
        Admin admin =(Admin) session.getAttribute("admin");
        if (admin != null) {
            // 세션에 사용자 정보가 있는 경우
            model.addAttribute("admin", admin);
            return "getAdmin";
        } else {
            // 세션에 사용자 정보가 없는 경우
            return "redirect:/login";
        }
    }


    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        session.removeAttribute(SessionConst.LOGIN_ADMIN);
        return "redirect:/admin/home";
    }


    @GetMapping("/admin/home")
    public String getHome(){
        return "admin-home";
    }

    // verification 관리 및 정렬
    @GetMapping("/admin/veri")
    public String getVeris(@RequestParam(name = "sortBy", defaultValue = "id") String sortBy, Model model) {
        //System.out.println("CHECK :: " + sortBy);
        List<Verification> verificationList = verificationService.findAll(sortBy);
        model.addAttribute("verification", verificationList);
        return "admin-verification";
    }

    @RequestMapping (value = "/admin/veri/update/{id}", method = RequestMethod.POST)
    public String updateStatus(@PathVariable Long id, @RequestParam(name = "status") String status){
        VerificationDTO veriDTO = new VerificationDTO();
        veriDTO.setStatus(Integer.parseInt(status));
        verificationService.updateStatus(id, veriDTO);
        //dto.setStatus(dto.getStatus());
        System.out.println("status22");
        return "redirect:/admin/veri";
    }


    //mentor black 관리
    @RequestMapping(value="/admin/mentor/update/{id}", method=RequestMethod.POST)
    public String updateMentorStatus(@PathVariable Long id, @RequestParam(name="status") String status){
        MentorDTO mentorDTO = new MentorDTO();
        mentorDTO.setStatus(String.valueOf(Integer.parseInt(status)));

        mentorService.updateMentorStatus(id, mentorDTO);
        return "redirect:/admin/mentor";
    }


    // mentee 관리 및 정렬
    @GetMapping("/admin/mentee")
    public String getMentees(@RequestParam(name = "sortBy", defaultValue = "id") String sortBy, Model model) {
        List<Mentee> mentees = menteeService.findAll(sortBy);
        model.addAttribute("mentees", mentees);
        return "admin-mentee";
    }

    // mentor 관리
    @GetMapping("/admin/mentor")
    public String getMentors(@RequestParam(name = "sortBy", defaultValue = "id") String sortBy, Model model) {
        List<Mentor> mentors = mentorService.findAllPass(sortBy);
        model.addAttribute("mentors", mentors);
        return "admin-mentor";
    }

    // 신청 관리 및 정렬
    @GetMapping("/admin/apply")
    public String getApplyList(@RequestParam(name = "sortBy", defaultValue = "id") String sortBy, Model model){
        List<Apply> applylist = applyService.findAll(sortBy);
        model.addAttribute("applylist", applylist);
        return "admin-apply";
    }

    // 매칭 관리
    @GetMapping("/admin/matching")
    public String getMatchings(@RequestParam(name = "sortBy", defaultValue = "id") String sortBy, Model model) {
        List<Matching> matching = matchingService.findAll(sortBy);
        System.out.println("EXPECTED :: " + matching);
        model.addAttribute("matching", matching);
        return "admin-matching";
    }

    // 채팅 관리
    @GetMapping("/admin/chat")
    public String getChats(Model model) {
        List<Chat> chat =  chatService.getAllChatList();
        model.addAttribute("chat", chat);
        return "admin-chat";
    }

    // 질문 관리
    @GetMapping("/admin/category")
    public String getCategoris(Model model) {
        List<CategoryDTO> categories = categoryService.findAll();
        model.addAttribute("category", categories);
        return "admin-category";
    }

}
