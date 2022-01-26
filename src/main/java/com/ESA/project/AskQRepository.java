package com.ESA.project;
// import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.ESA.project.AskQ.Type;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import aj.org.objectweb.asm.Type;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AskQRepository extends JpaRepository<AskQ,Long>{
    List<AskQ> findByType(Type type);
    // List<AskQ> search(java.lang.reflect.Type type);
}