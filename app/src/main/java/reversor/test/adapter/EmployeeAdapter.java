package reversor.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import reversor.test.R;
import reversor.test.data.EmployeeComparator;
import reversor.test.data.entity.Company;
import reversor.test.data.entity.Employee;

public class EmployeeAdapter extends BaseAdapter {
    private List<Employee> employees;
    private LayoutInflater layoutInflater;

    public EmployeeAdapter(Context context, Company company) {
        this.employees = company.getEmployees();
        Collections.sort(employees, new EmployeeComparator());
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int i) {
        return employees.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.element_list_view, viewGroup, false);
        }
        Employee employee = (Employee) getItem(i);

        StringBuilder description = new StringBuilder();
        description.append("Phone: ").append(employee.getPhoneNumber()).append("; ")
                .append(employee.getSkills());

        ((TextView) view.findViewById(R.id.name)).setText(employee.getName());
        ((TextView) view.findViewById(R.id.description)).setText(description.toString());
        return view;
    }
}
