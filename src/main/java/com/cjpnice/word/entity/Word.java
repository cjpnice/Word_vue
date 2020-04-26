package com.cjpnice.word.entity;

import java.io.Serializable;

/**
 * @author cjpnice
 */
public class Word implements Serializable {
    private Integer id;
    private String word;
    private Integer isRemember;
    private String translation;
    private String phonogram;
    private Integer forgetTime;
    private Integer reciteTime;

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", isRemember=" + isRemember +
                ", translation='" + translation + '\'' +
                ", phonogram='" + phonogram + '\'' +
                ", forgetTime=" + forgetTime +
                ", reciteTime=" + reciteTime +
                '}';
    }

    public Integer getReciteTime() {
        return reciteTime;
    }

    public void setReciteTime(Integer reciteTime) {
        this.reciteTime = reciteTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getIsRemember() {
        return isRemember;
    }

    public void setIsRemember(Integer isRemember) {
        this.isRemember = isRemember;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getPhonogram() {
        return phonogram;
    }

    public void setPhonogram(String phonogram) {
        this.phonogram = phonogram;
    }

    public Integer getForgetTime() {
        return forgetTime;
    }

    public void setForgetTime(Integer forgetTime) {
        this.forgetTime = forgetTime;
    }
}
