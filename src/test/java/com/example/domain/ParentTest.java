package com.example.domain;

import domain.Child;
import domain.Parent;
import org.junit.Assert;
import org.junit.Test;

public class ParentTest {

  @Test
  public void insertFindDelete() {
    Parent parent = new Parent();
    parent.name = "I am a parent";
    parent.save();

    Child child = new Child();
    child.name = "I am a child";
    child.parent = parent;
    child.save();

    parent.refresh();

    Assert.assertFalse("Should not be deleted yet", parent.child.deleted);

    child.delete();
    parent.refresh();

    Assert.assertNull(parent.child);
    // On ebean 17.11.0 and earlier this passes
    // On ebean 17.11.1 and later this fails with parent.child being <Child@0(id:1, deleted:false)>
  }
}
