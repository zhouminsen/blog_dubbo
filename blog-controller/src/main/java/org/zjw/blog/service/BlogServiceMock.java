package org.zjw.blog.service;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.zjw.blog.core.util.page.Page;
import org.zjw.blog.entity.Blog;
import org.zjw.blog.vo.BlogLuceneVo;
import org.zjw.blog.vo.BlogVo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BlogServiceMock implements BlogService {
    @Override
    public Page<Blog> getPageByCondition(Map<String, Object> queryMap) {
        Page<Blog> page = new Page<>();
        Blog blog = new Blog();
        blog.setContent("服务不可用额");
        page.getResultData().add(blog);
        return page;
    }

    @Override
    public List<Map<String, Object>> getDateCountByReleaseDate() {
        return null;
    }

    @Override
    public int getCountByCondition(Map<String, Object> queryMap) {
        return 0;
    }

    @Override
    public List<Blog> getAll() {
        return null;
    }

    @Override
    public Page<BlogLuceneVo> getPageBykeyword(Map<String, Object> queryMap) throws IOException, ParseException, InvalidTokenOffsetsException {
        return null;
    }

    @Override
    public BlogVo getVoById(Integer id) {
        return null;
    }

    @Override
    public Page<BlogVo> getPageByConditionToBack(Map<String, Object> queryMap) {
        return null;
    }

    @Override
    public int deleteLogicBatch(String[] idArray) throws IOException {
        return 0;
    }

    @Override
    public int restoreBatch(String[] idArray, Integer userId) {
        return 0;
    }

    @Override
    public Blog getById(Integer id) {
        return null;
    }

    @Override
    public int modify(Blog blog) throws IOException {
        return 0;
    }

    @Override
    public int save(Blog blog) throws IOException {
        return 0;
    }
}



















