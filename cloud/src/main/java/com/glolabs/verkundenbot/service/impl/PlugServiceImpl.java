package com.glolabs.verkundenbot.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.glolabs.verkundenbot.persistence.model.Plug;
import com.glolabs.verkundenbot.persistence.repository.IPlugRepository;
import com.glolabs.verkundenbot.service.IPlugService;

@Service
public class PlugServiceImpl implements IPlugService {

    private IPlugRepository plugRepository;

    public PlugServiceImpl(IPlugRepository plugRepository) {
        this.plugRepository = plugRepository;
    }

    @Override
    public Optional<Plug> findById(Integer id) {
        return plugRepository.findById(id);
    }

    @Override
    public Plug save(Plug plug) {
        if (StringUtils.isEmpty(plug.getId())) {
            plug.setDateCreated(LocalDate.now());
        }
        return plugRepository.save(plug);
    }

    @Override
    public Iterable<Plug> findAll() {
        return plugRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        plugRepository.deleteById(id);
    }

}
