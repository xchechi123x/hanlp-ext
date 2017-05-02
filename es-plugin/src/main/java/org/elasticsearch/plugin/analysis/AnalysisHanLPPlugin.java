package org.elasticsearch.plugin.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.HanLPAnalyzerProvider;
import org.elasticsearch.index.analysis.HanLPTokenizerFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AnalysisHanLPPlugin extends Plugin implements AnalysisPlugin {
    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> getTokenizers() {
        HashMap<String, AnalysisModule.AnalysisProvider<TokenizerFactory>> tokenizers = new HashMap<>();
        tokenizers.put("hanlp", HanLPTokenizerFactory::createStandard);
        tokenizers.put("hanlp-standard", HanLPTokenizerFactory::createStandard);
        tokenizers.put("hanlp-nlp", HanLPTokenizerFactory::createNLP);
        tokenizers.put("hanlp-index", HanLPTokenizerFactory::createIndex);
        tokenizers.put("hanlp-nshort", HanLPTokenizerFactory::createNShort);
        tokenizers.put("hanlp-shortest", HanLPTokenizerFactory::createShortest);
        tokenizers.put("hanlp-crf", HanLPTokenizerFactory::createCRF);
        tokenizers.put("hanlp-speed", HanLPTokenizerFactory::createSpeed);
        return tokenizers;
    }

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return Collections.singletonMap("hanlp", HanLPAnalyzerProvider::new);
    }

}