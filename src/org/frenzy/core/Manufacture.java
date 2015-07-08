package org.frenzy.core;

import java.util.ArrayList;
import java.util.List;

public class Manufacture {
    private final String NEGATIVE_INDEX_MESSAGE = "Department index can't be less than 0";
    private final String TOO_BIG_INDEX_MESSAGE = "Department index can't be more than departments count;";
    private List<Department> departments;

    public List<Department> getDepartments() {
        if (departments == null) {
            departments = new ArrayList<Department>();
        }
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        getDepartments().add(department);
    }

    public int getDepartmentsCount() {
        return getDepartments().size();
    }

    public Department getDepartment(int index) {
        if (index < 0) {
            throw new IllegalArgumentException(NEGATIVE_INDEX_MESSAGE);
        }

        List<Department> departments = getDepartments();
        if (index >= departments.size()) {
            throw new IllegalArgumentException(TOO_BIG_INDEX_MESSAGE);
        }

        return departments.get(index);
    }
}
