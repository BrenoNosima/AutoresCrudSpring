package com.bn.gerenciamentodeautorescs.repositories;

import com.bn.gerenciamentodeautorescs.models.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorReporitory extends JpaRepository<AutorModel,Long> {
}
