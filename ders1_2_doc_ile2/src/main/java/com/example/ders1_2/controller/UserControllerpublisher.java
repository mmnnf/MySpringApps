//package com.example.ders1_2.controller;
//
////import com.example.ders1_2.model.User;
////import com.example.ders1_2.model.messege;
////import com.example.ders1_2.repository.UserRepository;
//import com.example.ders1_2.model.User;
//import com.example.ders1_2.repository.UserRepository;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class UserControllerpublisher {
//    UserRepository userRepository;
//    @GetMapping("/dashboard")
//    public String  dashboard() {
//        return "Üyelere özel mesajdır";
//    }
//
//    @GetMapping("/index")
//    public String index(){
//        return "Merhaba. Üye Olun";
//    }
//
////    @GetMapping("/messages")
////    @ResponseBody
////    public List<messege> getmessages(Principal principal) {
////
////        String username= principal.getName();
////        User user = userRepository.findByName(username);
////        List<messege> messages=user.getMesseges();
////        return messages;
////    }
//
//
//
////    @GetMapping("/messages2")
////    @ResponseBody
////    public List<messege> getmessages(Model model) {
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////        String username = auth.getName();
////
////        User adminUser = userRepository.findByName(username);
////
////// DashboardItem obyektlərinin siyahısı təyin edilir
////        List<messege> dashboardItems = adminUser.getMesseges();
////
////// Məlumatlar modelə əlavə edilir
////       // dashboardItems
////        System.out.println(dashboardItems.get(0));
////        model.addAttribute("dashboardItems", dashboardItems);
////
////// dashboard.html şablonu çağırılır
////        return dashboardItems;
////
////    }
//public UserControllerpublisher(UserRepository userRepository) {
//    this.userRepository = userRepository;
//}
//
//
//    @GetMapping("/check")
//    @ResponseBody
//    public Boolean  check(Principal principal)throws UsernameNotFoundException {
//
//        String username= principal.getName();
//        User user=new User();
//        try
//        {
//            user = userRepository.findByName(username);
////            user = userRepository.findByName("Burak");
//        }
//        catch (NullPointerException e)
//        {
//            System.out.println(username);
//            System.out.println("sehvlik");
//        }
////        List<messege> messages=user.getMesseges();
//        Boolean b=false;
//        if (user ==null)
//            b=true;
//        return b;
//    }
//    @GetMapping("/user")
//    @ResponseBody
//    public String getuser(Principal principal) {
//        return principal.getName();
//    }
//    @GetMapping("/messagesbyid")
//    @ResponseBody
//    public String getmessagesbyid(Principal principal) {
//
//        String username= principal.getName();
//        User user = userRepository.findByName(username);
//        return user.getName()+" kkkk";
////        List<messege> messages=user.getMesseges();
////        return messages.get(0).toString();
//    }
//
//
//    @GetMapping("/user2")
//    @ResponseBody
//    public String getuser2(Principal principal) {
//
//        String username= principal.getName();
//
//        User user = userRepository.findByName(username);
//        // System.out.println(user.getRoles()+"rolu");
//        return user.getName();
//    }
//    @GetMapping("/role")
//    @ResponseBody
//    public String getrole(Principal principal) {
//
//        String username= principal.getName();
//
//        User user = userRepository.findByName(username);
//        // System.out.println(user.getRoles()+"rolu");
//        return user.getRoles().get(0).getRole_name();
//    }
//
//}