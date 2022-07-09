package sv.com.unicomer.jamaica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sv.com.unicomer.jamaica.exceptions.ModeloNotFoundException;
import sv.com.unicomer.jamaica.model.RequestSalespersonUpdate;
import sv.com.unicomer.jamaica.model.Salesperson;
import sv.com.unicomer.jamaica.service.ISalespersonService;

@RestController
@RequestMapping("/salesperson")
public class SalespersonController {
	private final ISalespersonService salespersonService;
	
	@Autowired
	public SalespersonController(ISalespersonService salespersonService) {
		// TODO Auto-generated constructor stub
		this.salespersonService = salespersonService;
	}
	
	/**************************************** list Salesperson ************************************/
	@ApiOperation(value = "Obtener todos los vendedores",
            notes = "No necesita parametros de entrada",
            responseContainer = "Salesperson")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Salesperson.class, responseContainer = "listSalesperson"
    )   
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, vendedor no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron vendedores en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
	
	@GetMapping
	public ResponseEntity<List<Salesperson>> listSalesperson(){
		List<Salesperson> listSalesperson = salespersonService.list();
		if(listSalesperson.isEmpty()) {
			throw new ModeloNotFoundException("No se encontraron elementos para mostrar ");
		}
		return new ResponseEntity<List<Salesperson>>(listSalesperson, HttpStatus.OK);
	}
	
	
	 /****************************************  Add Salesperson ************************************/
	 
	@ApiOperation(value = "agregar nuevos vendedores",
            notes = "Se necesita generales del vendedor",
            responseContainer = "Salesperson")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Salesperson.class, responseContainer = "List"
    )   
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, vendedor no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron vendedores en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
	   		 
	@PostMapping
	public  ResponseEntity<Salesperson> registrarLibro(@RequestBody RequestSalespersonUpdate salesperson) {
		 Salesperson person= new Salesperson(salesperson.getFirstName(),salesperson.getLastName(),salesperson.getBirthDay(),salesperson.getGender(),salesperson.getCellPhone(),salesperson.getAddressHome(),salesperson.getProfession(),salesperson.getIncomes());
		 ResponseEntity<Salesperson> resp;
		 try {
			  resp=new  ResponseEntity<Salesperson>(salespersonService.add(person),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ModeloNotFoundException(e.getMessage());
		}		 
		 return resp;	   
		 
	 }	
	 
	 
	 /*************************************** update salesperson ************************************/
	  
	@ApiOperation(value = "Modificar los vendedor",
            notes = "Se necesita id de vendedor",
            responseContainer = "Salesperson")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Salesperson.class, responseContainer = "update"
    )   
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, vendedor no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron vendedores en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
	
	 @PutMapping 
	 public ResponseEntity<Salesperson> update(@RequestBody Salesperson salesperson){
		
		 Salesperson obj = salespersonService.readById(salesperson.getIdSalesperson());
		 ResponseEntity<Salesperson> resp;
			if(obj.getIdSalesperson() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO " + salesperson.getIdSalesperson());
			}
			try {
				resp=new ResponseEntity<Salesperson>(salespersonService.update(salesperson),HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				throw new ModeloNotFoundException(e.getMessage());
			}
		 return resp;
	}
	 
	 

	
	
}
