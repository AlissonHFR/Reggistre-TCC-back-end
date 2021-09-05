package br.fai.reggistre.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fai.reggistre.api.service.AccountTypeService;
import br.fai.reggistre.model.entities.TipoConta;



@RestController
@RequestMapping("/api/v1/account-type")
@CrossOrigin(origins = "*")
public class AccountTypeRestController {
	
	@Autowired
	private AccountTypeService accountTypeService;
	
	@GetMapping("/read-all")
	public ResponseEntity< List<TipoConta>> readAll(){
		
		List<TipoConta> tipoContaList = accountTypeService.readAll();
		
		if(tipoContaList == null || tipoContaList.size() == 0) {
			return ResponseEntity.ok(null);
		}else {
			return ResponseEntity.ok(tipoContaList);
					
		}
		
	}
	
	@GetMapping("/read-by-id/{id}")
	public ResponseEntity<TipoConta> readById(@PathVariable("id")Long id){
		
		TipoConta tipoConta = accountTypeService.readById(id);
		
		if(tipoConta == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(tipoConta);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody TipoConta entity){
		
		boolean response = accountTypeService.update(entity);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody TipoConta entity){
		
		Long id = accountTypeService.create(entity);
		
		return ResponseEntity.ok(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id")Long id){
		
		boolean response = accountTypeService.deleteById(id);
		
		return ResponseEntity.ok(response);
		
	}

}
