package domain;

import io.ebean.Model;
import io.ebean.annotation.SoftDelete;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Parent extends Model {
  @Id public long id;

  public String name;

  @SoftDelete public boolean deleted;

  @OneToOne(mappedBy = "parent")
  public Child child;
}
