package com.wjj.controller;


import com.wjj.service.AnalyseService;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.data.DataSourceException;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.geometry.DirectPosition2D;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/analyse")
@CrossOrigin("*")
public class AnalyseController {


    @Autowired
    AnalyseService analyseService;

    // 高程分析
    @GetMapping("/getDem")
    public Double getDem(Double x,Double y,String tiffPath) throws IOException {
        double demData = analyseService.getDem(x,y,tiffPath);
        return demData;
    }








}
