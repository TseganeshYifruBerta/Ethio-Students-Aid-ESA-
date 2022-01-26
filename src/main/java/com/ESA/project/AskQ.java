package com.ESA.project;
// import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.OneToMany;
import javax.persistence.Table;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;

// import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

// import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
// @Type
@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
public class AskQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @NotBlank(message="write your name please")
    private String username;
    // @NotBlank(message="please select the question type you want to ask")
    private String question;
    private Type type;
    // @NotNull
    // @Size(min = 5, message = "question must be at least 15 characters long")    private String question;
    private String answer;



    

    // @JsonBackReference

    // @OneToMany(mappedBy="question")
    // List<Answers> answers;


    // AskQ(){}
    // AskQ(String username,String question,String answer){
    //     this.username = username;
    //     this.question = question;
    //     this.answer=answer;
    // }
        
    // public AskQ(Type type) {
    //   this.type = type;
    // }





    // }
    public enum Type{
      PHYSICS,CHEMISTRY,MATHS,ENGLISH,PROGRAMMING,GEOGRAPHY,ART, PSYCHOLOGY,HISTORY,CIVICS,BIOLOGY;
      private Type(){
        
      }
    }
   
    // @OneToMany(mappedBy = "branch")
    // List<Account> accounts;

}