package com.TekUp.VentTNDemo.Repositories;

import com.TekUp.VentTNDemo.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
