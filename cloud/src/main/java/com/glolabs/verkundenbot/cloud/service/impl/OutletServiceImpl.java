package com.glolabs.verkundenbot.cloud.service.impl;

import org.threeten.bp.LocalDateTime;
import java.util.Optional;

import com.glolabs.verkundenbot.cloud.persistence.model.Outlet;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.glolabs.verkundenbot.cloud.persistence.repository.IOutletRepository;
import com.glolabs.verkundenbot.cloud.service.IOutletService;

@Service
public class OutletServiceImpl implements IOutletService {

    private IOutletRepository outletRepository;

    public OutletServiceImpl(IOutletRepository outletRepository) {
        this.outletRepository = outletRepository;
    }

    @Override
    public Optional<Outlet> findById(Long id) {
        return outletRepository.findById(id);
    }

    @Override
    public Outlet save(Outlet outlet) {
        if (StringUtils.isEmpty(outlet.getId())) {
            outlet.setCreatedTime(LocalDateTime.now());
        }
        return outletRepository.save(outlet);
    }

    @Override
    public Iterable<Outlet> findAll() {
        return outletRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        outletRepository.deleteById(id);
    }

}
