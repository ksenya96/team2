package dev.java.db.model1;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "candidateFeedback", schema = "staffjobs")
public class CandidateFeedback extends AbstractEntity {
  /*  private String name;
    private String surname;
    private Date birthday;
    private BigDecimal salaryInDollars;
    private List<CandidateExperience> experiences = new ArrayList<>();
    private Set<Skill> skills = new HashSet<>();
    private CandidateState candidateState;
    private List<Attachment> attachments = new ArrayList<>();
    private List<ContactDetails> contactDetails = new ArrayList<>();

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return super.getId();
    }


    @Basic
    @Column(name = "name", nullable = false, length = 255)
    @SuppressWarnings("checkstyle:MagicNumber")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 255)
    @SuppressWarnings("checkstyle:MagicNumber")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        if (birthday == null) {
            return null;
        }
        return new Date(birthday.getTime());
    }

    public void setBirthday(Date birthday) {
        if (birthday == null) {
            this.birthday = null;
            return;
        }
        this.birthday = new Date(birthday.getTime());
    }

    @Basic
    @Column(name = "salary_in_dollars", nullable = true, precision = 2)
    @SuppressWarnings("checkstyle:MagicNumber")
    public BigDecimal getSalaryInDollars() {
        return salaryInDollars;
    }

    public void setSalaryInDollars(BigDecimal salaryInDollars) {
        this.salaryInDollars = salaryInDollars;
    }


    @ElementCollection
    @CollectionTable(
            name = "candidate_experience",
            joinColumns = @JoinColumn(name = "id_candidate")
    )
    @AttributeOverrides({
            @AttributeOverride(name = "dateFrom", column = @Column(name = "date_from", nullable = false)),
            @AttributeOverride(name = "dateTo", column = @Column(name = "date_to", nullable = false))
    })
    public List<CandidateExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<CandidateExperience> experiences) {
        this.experiences = experiences;
    }

    @ManyToMany
    @JoinTable(name = "candidate_competence",
            joinColumns = {@JoinColumn(name = "id_candidate", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "skill", referencedColumnName = "name")}
    )
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @ManyToOne
    @JoinColumn(name = "candidate_state", referencedColumnName = "name")
    public CandidateState getCandidateState() {
        return candidateState;
    }

    public void setCandidateState(CandidateState candidateState) {
        this.candidateState = candidateState;
    }

    @ElementCollection
    @CollectionTable(
            name = "attachment",
            joinColumns = @JoinColumn(name = "id_candidate")
    )
    @AttributeOverrides({
            @AttributeOverride(name = "filePath", column = @Column(name = "file_path",
                    nullable = false, length = 1000)),
            @AttributeOverride(name = "attachmentType", column = @Column(name = "attachment_type", nullable = false))
    })
    @SuppressWarnings("checkstyle:MagicNumber")
    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @ElementCollection
    @CollectionTable(
            name = "contact_details",
            joinColumns = @JoinColumn(name = "id_candidate")
    )
    @AttributeOverrides({
            @AttributeOverride(name = "contactType", column = @Column(name = "contact_type", nullable = false)),
            @AttributeOverride(name = "contactDetails", column = @Column(name = "contact_details",
                    nullable = false, length = 1000))
    })
    @SuppressWarnings("checkstyle:MagicNumber")
    public List<ContactDetails> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(List<ContactDetails> contactDetails) {
        this.contactDetails = contactDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CandidateFeedback candidateFeedback = (CandidateFeedback) o;
        return Objects.equals(name, candidateFeedback.name)
                && Objects.equals(surname, candidateFeedback.surname)
                && Objects.equals(birthday, candidateFeedback.birthday)
                && Objects.equals(salaryInDollars, candidateFeedback.salaryInDollars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday);
    }

    @Override
    public String toString() {
        return "CandidateFeedback{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", birthday=" + birthday
                + ", salaryInDollars=" + salaryInDollars
                + ", experiences=" + experiences
                + ", skills=" + skills
                + '}';
    } */
}
