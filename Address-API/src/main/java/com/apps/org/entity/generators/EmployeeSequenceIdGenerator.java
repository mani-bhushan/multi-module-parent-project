package com.apps.org.entity.generators;

import java.io.Serializable;
import java.util.Properties;

/*import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(
        name = "EMP_SEQ",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "EMP_SEQ"),
                @Parameter(name = "initial_value", value = "1000"),
                @Parameter(name = "increment_size", value = "1")
        }
)*/

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

public class EmployeeSequenceIdGenerator extends SequenceStyleGenerator {

	public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
	public static final String VALUE_PREFIX_DEFAULT = "";
	private String valuePrefix;

	public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
	public static final String NUMBER_FORMAT_DEFAULT = "%d";
	private String numberFormat;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return valuePrefix + String.format(numberFormat, super.generate(session, object));
	}

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT);
		numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
	}
	
	
//	public static final String DATE_FORMAT_PARAMETER = "dateFormat";
//    public static final String DATE_FORMAT_DEFAULT = "%tY-%tm";
//    public static final String NUMBER_FORMAT_D_PARAMETER = "numberFormat";
//    public static final String NUMBER_FORMAT_D_DEFAULT = "%05d";
//     
//    public static final String DATE_NUMBER_SEPARATOR_PARAMETER = "dateNumberSeparator";
//    public static final String DATE_NUMBER_SEPARATOR_DEFAULT = "_";
//     
//    private String format;
//    
//    @Override
//    public Serializable generate(SharedSessionContractImplementor session,
//            Object object) throws HibernateException {
//        return String.format(format, LocalDate.now(), super.generate(session, object));
//    }
//    
//    @Override
//    public void configure(Type type, Properties params,
//            ServiceRegistry serviceRegistry) throws MappingException {
//        super.configure(LongType.INSTANCE, params, serviceRegistry);
// 
//        String dateFormat = ConfigurationHelper.getString(DATE_FORMAT_PARAMETER, params, DATE_FORMAT_DEFAULT).replace("%", "%1"); 
//        String numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT).replace("%", "%2"); 
//        String dateNumberSeparator = ConfigurationHelper.getString(DATE_NUMBER_SEPARATOR_PARAMETER, params, DATE_NUMBER_SEPARATOR_DEFAULT); 
//        this.format = dateFormat+dateNumberSeparator+numberFormat; 
//    }

}
