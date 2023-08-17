package movieBlog.security;

import lombok.RequiredArgsConstructor;
import movieBlog.entites.Role;
import movieBlog.security.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getUserRole(){
        return roleRepository.findByName("ROLE_USER").get();
    }
}
