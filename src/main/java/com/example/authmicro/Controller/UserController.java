import com.example.authmicro.Model.User;
import com.example.authmicro.Service.RegistrationService;
import com.example.authmicro.dto.UserRegistrationRequest;
import com.example.authmicro.dto.OAuth2RegistrationRequest;
import com.example.authmicro.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private RegistrationService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest request) {
        try {
            User user = userService.register(request);
            return ResponseEntity.ok(user);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body("User already exists");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal server error");
        }
    }

    @PostMapping("/register/oauth")
    public ResponseEntity<?> registerOAuth(@RequestBody OAuth2RegistrationRequest request) {
        try {
            User user = userService.registerOAuth(request);
            return ResponseEntity.ok(user);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body("User already exists");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Internal server error");
        }
    }
}
