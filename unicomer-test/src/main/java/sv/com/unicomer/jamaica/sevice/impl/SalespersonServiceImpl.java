package sv.com.unicomer.jamaica.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sv.com.unicomer.jamaica.model.Salesperson;
import sv.com.unicomer.jamaica.repositorio.ISalespersonRepository;
import sv.com.unicomer.jamaica.service.ISalespersonService;

@Service
public class SalespersonServiceImpl implements ISalespersonService {

	private final ISalespersonRepository repository;
	
	@Autowired
	public SalespersonServiceImpl( ISalespersonRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@Transactional
	@Override
	public Salesperson add(Salesperson obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Transactional
	@Override
	public Salesperson update(Salesperson obj) {
		// TODO Auto-generated method stub
		Optional<Salesperson> optSalesperson =repository.findById(obj.getIdSalesperson());
		if(optSalesperson.isPresent()) {
			return repository.save(obj);
		}else {
			return new Salesperson();
		}
		
	}

	@Override
	public List<Salesperson> list() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Salesperson readById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Salesperson> optSalesperson = repository.findById(id);
		if(optSalesperson.isPresent()) {
			return optSalesperson.get();
		}else {
			return new Salesperson();
		}
		
	}
	
	@Transactional
	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	

}
