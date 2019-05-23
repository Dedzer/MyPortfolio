package project.model;

import org.bson.types.ObjectId;

import java.util.Date;

public class ProjectsModel {
    private ObjectId id;
    private String name;
    private String description;
    private Date startDate;
    private Boolean finished;

    public ProjectsModel(String name, String description, Date startDate, Boolean finished, ObjectId id) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finished = finished;
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ProjectsModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
