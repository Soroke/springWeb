package com.web.Return;

/**
 * Created by song on 2017/7/20.
 */
public class Exam {

    public int getExamType() {
        return examType;
    }

    public void setExamType(int examType) {
        this.examType = examType;
    }

    public int getLanguageType() {
        return languageType;
    }

    public void setLanguageType(int languageType) {
        this.languageType = languageType;
    }

    public String getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(String examPaper) {
        this.examPaper = examPaper;
    }

    public String getExamDiploma() {
        return examDiploma;
    }

    public void setExamDiploma(String examDiploma) {
        this.examDiploma = examDiploma;
        String[] dip = examDiploma.split(";");
        this.examDiplomaId = dip[0];
        this.examDiplomaName = dip[1];
    }

    public String getDatetimeEnd() {
        return datetimeEnd;
    }

    public void setDatetimeEnd(String datetimeEnd) {
        this.datetimeEnd = datetimeEnd;
    }

    public String getDatetimeStart() {
        return datetimeStart;
    }

    public void setDatetimeStart(String datetimeStart) {
        this.datetimeStart = datetimeStart;
    }

    public String getDomainCode() {
        return domainCode;
    }

    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    public int getExamCount() {
        return examCount;
    }

    public void setExamCount(int examCount) {
        this.examCount = examCount;
    }


    public String getExamDiplomaId() {
        return examDiplomaId;
    }

    public void setExamDiplomaId(String examDiplomaId) {
        this.examDiplomaId = examDiplomaId;
    }

    public String getExamDiplomaName() {
        return examDiplomaName;
    }

    public void setExamDiplomaName(String examDiplomaName) {
        this.examDiplomaName = examDiplomaName;
    }

    private int examType;
    private int languageType;
    private String examPaper;
    private String examDiploma;
    private String examDiplomaId;
    private String examDiplomaName;
    private String datetimeEnd;
    private String datetimeStart;
    private String domainCode;
    private int examCount;
}
