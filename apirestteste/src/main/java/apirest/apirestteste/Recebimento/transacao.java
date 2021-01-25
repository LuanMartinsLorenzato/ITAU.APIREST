package apirest.apirestteste.Recebimento;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class transacao {
   public int count;
    @RequestMapping(value = "/transacao", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DTO> getvd(@RequestBody DTO DTO) 
    {
        if(DTO.valor > 0 && DTO.dataHora.length() == 29)
        {   
                return new ResponseEntity<DTO>(HttpStatus.CREATED);                
            }
                else if(DTO.valor < 0 || DTO.dataHora.length() != 29)
            {  
                    DTO.valor = 0.0;        
                    return new ResponseEntity<DTO>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
                else
            {
                    return new ResponseEntity<DTO>(HttpStatus.BAD_REQUEST);
        }
    }
}
