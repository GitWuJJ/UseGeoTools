package com.wjj.service.impl;

import com.wjj.dao.AnalyseMapper;
import com.wjj.service.AnalyseService;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.data.DataSourceException;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.geometry.DirectPosition2D;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AnalyseServiceImpl implements AnalyseService {

//
//    @Autowired
//    AnalyseMapper analyseMapper;


    @Override
    public double getDem(Double x,Double y,String tiffPath) throws IOException {
        GeoTiffReader reader = new GeoTiffReader(tiffPath);
        GridCoverage2D coverage2D = reader.read(null);

        // 坐标系
        CoordinateReferenceSystem crs = coverage2D.getCoordinateReferenceSystem2D();

        // 创建Point对象
        DirectPosition2D point = new DirectPosition2D(crs, x, y);

        float[] demData = (float[]) coverage2D.evaluate(point);

        return demData[0];

    }
}
