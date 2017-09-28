package com.ckt.jmetertools.functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import com.ckt.utils.PictureUtils;

/**
 * 
 * @ClassName: Picture2Base64 
 * @Description: make picture to base64
 * @author jianbin.zhong
 * @date 2017年9月27日 下午5:08:31 
 *
 */
public class Picture2Base64 extends AbstractFunction{
	private static final List<String> desc = new LinkedList<String>();
	private static final String KEY = "_Pic2Base64";
	private static int MAX_PARAM_COUNT = 1;
    private static final int MIN_PARAM_COUNT = 1;
    private Object[] values;
    
    static {
        desc.add("a picture path");
    }
    
	@Override
	public List<String> getArgumentDesc() {
		return desc;
	}

	@Override
	public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {
		String picture = new String(((CompoundVariable) values[0]).execute().trim());
		PictureUtils utils = new PictureUtils();
		String base64 = utils.pic2Base64(picture);
		return base64;
	}

	@Override
	public String getReferenceKey() {
		return KEY;
	}

	@Override
	public void setParameters(Collection<CompoundVariable> arg0) throws InvalidVariableException {
		//检查并获取参数
		checkParameterCount(arg0, MIN_PARAM_COUNT,MAX_PARAM_COUNT);
		values = arg0.toArray();
	}
}
