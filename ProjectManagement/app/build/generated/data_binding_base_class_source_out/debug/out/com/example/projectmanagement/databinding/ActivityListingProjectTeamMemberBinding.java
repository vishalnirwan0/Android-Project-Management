// Generated by view binder compiler. Do not edit!
package com.example.projectmanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projectmanagement.R;
import de.codecrafters.tableview.TableView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityListingProjectTeamMemberBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final Guideline guideline38;

  @NonNull
  public final Guideline guideline39;

  @NonNull
  public final Guideline guideline4;

  @NonNull
  public final Guideline guideline40;

  @NonNull
  public final Guideline guideline41;

  @NonNull
  public final Guideline guideline42;

  @NonNull
  public final Guideline guideline5;

  @NonNull
  public final Guideline guideline6;

  @NonNull
  public final ImageView imageTeamMember;

  @NonNull
  public final TableView tableViewProjectListingTeamMember;

  @NonNull
  public final TextView txtMemberUserName;

  @NonNull
  public final TextView txtMemberUserRole;

  private ActivityListingProjectTeamMemberBinding(@NonNull ConstraintLayout rootView,
      @NonNull Guideline guideline3, @NonNull Guideline guideline38, @NonNull Guideline guideline39,
      @NonNull Guideline guideline4, @NonNull Guideline guideline40, @NonNull Guideline guideline41,
      @NonNull Guideline guideline42, @NonNull Guideline guideline5, @NonNull Guideline guideline6,
      @NonNull ImageView imageTeamMember, @NonNull TableView tableViewProjectListingTeamMember,
      @NonNull TextView txtMemberUserName, @NonNull TextView txtMemberUserRole) {
    this.rootView = rootView;
    this.guideline3 = guideline3;
    this.guideline38 = guideline38;
    this.guideline39 = guideline39;
    this.guideline4 = guideline4;
    this.guideline40 = guideline40;
    this.guideline41 = guideline41;
    this.guideline42 = guideline42;
    this.guideline5 = guideline5;
    this.guideline6 = guideline6;
    this.imageTeamMember = imageTeamMember;
    this.tableViewProjectListingTeamMember = tableViewProjectListingTeamMember;
    this.txtMemberUserName = txtMemberUserName;
    this.txtMemberUserRole = txtMemberUserRole;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityListingProjectTeamMemberBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityListingProjectTeamMemberBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_listing_project_team_member, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityListingProjectTeamMemberBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.guideline3;
      Guideline guideline3 = ViewBindings.findChildViewById(rootView, id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.guideline38;
      Guideline guideline38 = ViewBindings.findChildViewById(rootView, id);
      if (guideline38 == null) {
        break missingId;
      }

      id = R.id.guideline39;
      Guideline guideline39 = ViewBindings.findChildViewById(rootView, id);
      if (guideline39 == null) {
        break missingId;
      }

      id = R.id.guideline4;
      Guideline guideline4 = ViewBindings.findChildViewById(rootView, id);
      if (guideline4 == null) {
        break missingId;
      }

      id = R.id.guideline40;
      Guideline guideline40 = ViewBindings.findChildViewById(rootView, id);
      if (guideline40 == null) {
        break missingId;
      }

      id = R.id.guideline41;
      Guideline guideline41 = ViewBindings.findChildViewById(rootView, id);
      if (guideline41 == null) {
        break missingId;
      }

      id = R.id.guideline42;
      Guideline guideline42 = ViewBindings.findChildViewById(rootView, id);
      if (guideline42 == null) {
        break missingId;
      }

      id = R.id.guideline5;
      Guideline guideline5 = ViewBindings.findChildViewById(rootView, id);
      if (guideline5 == null) {
        break missingId;
      }

      id = R.id.guideline6;
      Guideline guideline6 = ViewBindings.findChildViewById(rootView, id);
      if (guideline6 == null) {
        break missingId;
      }

      id = R.id.imageTeamMember;
      ImageView imageTeamMember = ViewBindings.findChildViewById(rootView, id);
      if (imageTeamMember == null) {
        break missingId;
      }

      id = R.id.tableViewProjectListingTeamMember;
      TableView tableViewProjectListingTeamMember = ViewBindings.findChildViewById(rootView, id);
      if (tableViewProjectListingTeamMember == null) {
        break missingId;
      }

      id = R.id.txtMemberUserName;
      TextView txtMemberUserName = ViewBindings.findChildViewById(rootView, id);
      if (txtMemberUserName == null) {
        break missingId;
      }

      id = R.id.txtMemberUserRole;
      TextView txtMemberUserRole = ViewBindings.findChildViewById(rootView, id);
      if (txtMemberUserRole == null) {
        break missingId;
      }

      return new ActivityListingProjectTeamMemberBinding((ConstraintLayout) rootView, guideline3,
          guideline38, guideline39, guideline4, guideline40, guideline41, guideline42, guideline5,
          guideline6, imageTeamMember, tableViewProjectListingTeamMember, txtMemberUserName,
          txtMemberUserRole);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
