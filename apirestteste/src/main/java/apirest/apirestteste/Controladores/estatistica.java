package apirest.apirestteste.Controladores;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import apirest.apirestteste.Recebimento.DTO;

@RestController
public class estatistica {

    public Double[] statisticval = {};
    public Double[] newVal = {};
    
    @RequestMapping(value = "/estatistica", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)        
    public java.lang.String getres (@RequestBody DTO DTO) 
    {
       
    java.util.Arrays.fill (statisticval, DTO.valor);
    java.util.Arrays.fill (newVal, DTO.valor);
    Double sum = 0.0;
    Double avg = 0.0;
    Double max = 0.0;
    Double min = 999999999999.99;
    
    int count = statisticval.length + 1;
    
    for(int i = 0; i < statisticval.length; i++)
    {
        sum += statisticval[i];
        avg = sum / count;
    
        if(statisticval[i] > max)
        {
            max = statisticval[i];
        }
    
        if(statisticval[i] < min)
        {
            min = statisticval[i]; 
        }
    }
       return "Teste";
    }
}
