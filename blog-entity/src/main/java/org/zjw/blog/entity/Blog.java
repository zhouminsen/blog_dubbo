package org.zjw.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author 周家伟
 * @date 2016-7-16
 */
@Data
public class Blog implements Serializable {
    private Integer id;

    private String title;

    private String summary;

    private Date releaseDate;

    private Integer clickHit;

    private Integer replyHit;

    private Integer typeId;

    private String keyWord;

    private String content;
    
    private Integer userId;
    
    private Integer state;

	private List<String> imgList=new ArrayList<String>();

    private Date createDate;
    private String deleteFlag;


    public Blog() {
		super();
	}

	public Blog(Integer id) {
		super();
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "Blog [id=" + id + ", title=" + title + ", summary=" + summary
                + ", releaseDate=" + releaseDate + ", clickHit=" + clickHit
                + ", replyHit=" + replyHit + ", typeId=" + typeId
                + ", keyWord=" + keyWord + ", content=" + content + ", userId="
                + userId + ", state=" + state + ", imgList=" + imgList
                + ", getCreateDate()=" + getCreateDate() + ", getDeleteFlag()="
                + getDeleteFlag() + "]";
    }


}