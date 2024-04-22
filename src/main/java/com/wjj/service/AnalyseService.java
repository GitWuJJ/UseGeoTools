package com.wjj.service;

import org.geotools.data.DataSourceException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface AnalyseService {
    double getDem(Double x,Double y,String tiffPath) throws IOException;
}
