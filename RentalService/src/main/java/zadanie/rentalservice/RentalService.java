package zadanie.rentalservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {

    private final RestTemplate restTemplate;
    private final String fooResourceUrl = "http://localhost:8080/movies/";
    private final String movieServiceHost2 = "http://localhost:8080/movies/";


    public RentalService(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;

    }

    public Movie getMovie(Long id) {


        try {
            restTemplate.setErrorHandler(new RestTemplateErrors());
            return restTemplate.getForObject(fooResourceUrl + id, Movie.class);
        } catch (ResourceAccessException ex) {
            throw new GatewayTimeoutException();
        }

    }

    public void returnMovie(Long id) {


        try {
            restTemplate.setErrorHandler(new RestTemplateErrors());
            restTemplate.put(fooResourceUrl + "/return/" + id, Movie.class);
        } catch (ResourceAccessException ex) {
            throw new GatewayTimeoutException();
        }
    }

    public void rentMovie(Long id) {

        try {
            restTemplate.setErrorHandler(new RestTemplateErrors());
            restTemplate.put(fooResourceUrl + "/rent/" + id, Movie.class);
        } catch (ResourceAccessException ex) {
            throw new GatewayTimeoutException();
        }

    }


}




