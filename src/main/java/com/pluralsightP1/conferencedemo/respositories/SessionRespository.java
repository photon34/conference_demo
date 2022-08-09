package com.pluralsightP1.conferencedemo.respositories;

import com.pluralsightP1.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRespository extends JpaRepository<Session, Long> {
}
