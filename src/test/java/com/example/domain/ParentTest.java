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
  }
}
