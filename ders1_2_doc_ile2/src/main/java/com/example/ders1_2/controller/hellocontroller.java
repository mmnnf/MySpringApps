//package com.example.ders1_2.controller;
//
//import com.example.ders1_2.methods.checkingRole;
//import com.example.ders1_2.model.Role;
//import com.example.ders1_2.service.roleservices;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.security.Principal;
//import java.util.List;
//
//@RestController
//@RequestMapping
//@RequiredArgsConstructor
//@Slf4j
//public class hellocontroller {
//    private final checkingRole checkingRole;
//    private final roleservices roleservices;
//    @GetMapping("/hello")
//    public String sayHello(  )
//    {
//        return "salam";
//    }
//
//    @GetMapping("/hello/2")
//    public String sayHello2(  )
//    {
//        return "s22";
//    }
//
//
//
//    //ASAGIDAKI CONTROLLER ADMIN ROLUNA ICAZE VERIR, AMMA BASQA ROLA ICAZE VERMIR:
//    //SADECE JWT ILE LOGIN OLAN SHEXSIN PRIMCIPALINDAN ROLU GOTURUB ICAZELERI EDIRIK
//    @GetMapping("/bello")
//    //@RolesAllowed("ROLE_ADMIN")
//    public String sayHello3(Principal principal)
//    {
//        List<Role> rol= roleservices.getrolesbyname(principal);
//        System.out.println(rol.get(0).getRole_name());
//        for (Role a:rol)
//        {
//            if (a.getRole_name().equalsIgnoreCase("Role_Admin"))
//            {
//                return "security";
//            }
//        }
//       // return "security";
//        throw new ResponseStatusException(HttpStatus.FORBIDDEN);
//    }
//
//    @GetMapping("/zello")
//    //@RolesAllowed("ROLE_ADMIN")
//    public String zello(Principal principal)
//    {
//        if (principal==null)
//            log.info("null imish");
//        if (checkingRole.checkRole(principal,"ROLE_ADMIN")==null)
//            log.info("icerideki null imish");
//       if (checkingRole.checkRole(principal,"ROLE_ADMIN"))
//       {
//           return "zello";
//       }
//       else {
//             throw new ResponseStatusException(HttpStatus.FORBIDDEN);
//       }
//    }
//    private Boolean checkRole(Principal principal,String role)
//    {
//        List<Role> rol= roleservices.getrolesbyname(principal);
//        for (Role a:rol)
//        {
//            if (a.getRole_name().equalsIgnoreCase(role))
//            {
//               return true;
//            }
//        }
//        return false;
//    }
//
//    @GetMapping("/sec")
////    @PreAuthorize("hasRole('ADMIN')")
////    @RolesAllowed({"ROLE_ADMIN"})
////    @RolesAllowed("ROLE_ADMIN")
//    public String secure(  )
//    {
//        return "secureddd";
//    }
//
//}
