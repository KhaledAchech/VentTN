package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client,Long> {
}
