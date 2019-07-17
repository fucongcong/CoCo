package {{ group }}.{{ module }}.web.controller;

import com.clothesmake.common.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/{{ module }}")
public class {{ name }}Controller {
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public Result<String> index(@PathVariable Integer id) {
        return Result.success("hello world");
    }
}   
