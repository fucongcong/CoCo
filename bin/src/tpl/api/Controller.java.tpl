package {{ group }}.{{ module }}.web.controller;

import com.clothesmake.common.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/{{ module }}")
public class {{ Uname }}Controller {
    @RequestMapping(value = "/{{ name }}", method = RequestMethod.GET)
    public Result<String> index() {
        return Result.success("hello world");
    }
}   
