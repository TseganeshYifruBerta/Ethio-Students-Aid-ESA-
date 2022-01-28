package com.ESA.project;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "questions")
@AllArgsConstructor
@NoArgsConstructor
public class AskQ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="write your name please")
    private String username;
    @NotBlank(message="please write the question you want to ask")
    private String question;
    private Type type;
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