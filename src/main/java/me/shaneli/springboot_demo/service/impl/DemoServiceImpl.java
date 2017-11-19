package me.shaneli.springboot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

import me.shaneli.springboot_demo.dao.DemoMapper;
import me.shaneli.springboot_demo.model.Demo;
import me.shaneli.springboot_demo.service.DemoService;

/**
 * @author Shane
 */
@Service
public class DemoServiceImpl implements DemoService {

    private static final String CACHE_KEY = "cache_key";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public Demo queryDemoById(int id) {
        return this.demoMapper.selectById(id);
    }

    @Override
    @Transactional
    public boolean addDemo(Demo demo) {
        return this.demoMapper.insertDemo(demo) > 0;
    }

    @Override
    public void putToCache(String value) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        ops.set(CACHE_KEY, value, 1, TimeUnit.MINUTES);
    }

    @Override
    public String queryFromCache() {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();

        return ops.get(CACHE_KEY);
    }
}
