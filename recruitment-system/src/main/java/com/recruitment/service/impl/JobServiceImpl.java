package com.recruitment.service.impl;

import com.recruitment.common.Result;
import com.recruitment.data.MockDataStore;
import com.recruitment.model.Job;
import com.recruitment.service.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Override
    public Result<List<Job>> list(String city, String keyword) {
        // 第 1 步：准备结果列表
        List<Job> result = new ArrayList<>();

        // 第 2、3 步：遍历所有职位，按 city 和 keyword 过滤
        for (Job job : MockDataStore.getJobs()) {
            if (matchCity(job, city) && matchKeyword(job, keyword)) {
                result.add(job);
            }
        }

        return Result.success(result);
    }

    @Override
    public Result<Job> detail(Long id) {
        // 第 1 步：按 id 去仓库里查
        Job job = MockDataStore.getJobById(id);

        // 第 2 步：查不到就返回错误
        if (job == null) {
            return Result.error("职位不存在");
        }

        // 第 3 步：找到了，浏览量 +1，再返回
        job.setViewCount(job.getViewCount() + 1);
        return Result.success(job);
    }

    private boolean matchCity(Job job, String city) {
        if (city == null || city.trim().isEmpty()) {
            return true; // 没传说明不过滤，匹配上了
        }
        return city.equals(job.getCity());
    }

    private boolean matchKeyword(Job job, String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return true;
        }
        String realKeyword = keyword.trim();
        return job.getCompanyName().contains(realKeyword)
                || job.getJobTitle().contains(realKeyword);
    }
}