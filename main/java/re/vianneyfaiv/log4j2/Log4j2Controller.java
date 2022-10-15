package re.vianneyfaiv.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Log4j2Controller {

	private final static Logger LOGGER = LoggerFactory.getLogger(Log4j2Controller.class);

    @RequestMapping
    public void test() {
    	LOGGER.error("This is a test");
    }

    @RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name",
	defaultValue = "Robot") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1);
		response.setMessage("Your name is " + name);
        LOGGER.info("API is called for user {}", name);
		return response;

	}
}
