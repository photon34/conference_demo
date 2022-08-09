package com.pluralsightP1.conferencedemo.respositories;

import com.pluralsightP1.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRespository extends JpaRepository<Speaker, Long> {
}
