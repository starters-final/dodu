package com.starters.dodu.controller;

import com.starters.dodu.domain.*;
import com.starters.dodu.dto.CategoryDTO;
import com.starters.dodu.service.*;
import com.starters.dodu.utils.SessionConst;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
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

    // varification 관리
    @GetMapping("/admin/veri")
    public String getVeris(Model model) {
        List<Verification> verification = verificationService.findAll();
        model.addAttribute("verification", verification);
        return "admin-verification";
    }

    // mentee 관리
    @GetMapping("/admin/mentee")
    public String getMentees(Model model) {
        List<Mentee> mentees = menteeService.findAll();
        model.addAttribute("mentees", mentees);
        return "admin-mentee";
    }

    // mentor 관리
    @GetMapping("/admin/mentor")
    public String getMentors(Model model) {
        List<Mentor> mentors = mentorService.findAllPass();
        model.addAttribute("mentors", mentors);
        return "admin-mentor";
    }

    // 신청관리
    @GetMapping("/admin/apply")
    public String getApplyList(Model model){
        List<Apply> applylist = applyService.findAll();
        model.addAttribute("applylist", applylist);
        return "admin-apply";
    }

    // 매칭 관리
    @GetMapping("/admin/matching")
    public String getMatchings(Model model) {
        List<Matching> matching = matchingService.findAll();
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
