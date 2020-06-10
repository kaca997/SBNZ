package com.bsep.recipes.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.drools.template.ObjectDataCompiler;
import org.springframework.stereotype.Service;

import com.bsep.recipes.dto.RuleDTO;

@Service
public class NewRuleService {

	public void addNewRule(RuleDTO dto) throws IOException {
		InputStream template = NewRuleService.class.getResourceAsStream("/rules/userTemplate.drt");

        List<RuleDTO> data = new ArrayList<>();

        data.add(dto);

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);
        System.out.println(drl);
        int startIndex = drl.indexOf("rule \"");
        drl = drl.substring(startIndex);
        Files.write(Paths.get("src/main/resources/rules/userRules.drl"), drl.getBytes(), StandardOpenOption.APPEND);
	}
}
